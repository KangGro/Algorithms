package com.mr.kangaroo.klasscode;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Handle;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.invoke.*;

import static jdk.internal.org.objectweb.asm.Opcodes.V1_7;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_SUPER;
import static jdk.internal.org.objectweb.asm.Opcodes.ALOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static jdk.internal.org.objectweb.asm.Opcodes.RETURN;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC;

/**
 * @author daisy
 * @desc
 * @create 2018/9/13
 */
public class InvokeDynamicCreator {
    public static void main(final String[] args) throws Exception {
        final String outputClassName = "Dynamic";
        try (FileOutputStream fos
                     = new FileOutputStream(new File("/Users/mr-kangaroo/git/Algorithms/src/com/mr/kangaroo/klasscode/" + outputClassName + ".class"))) {
            fos.write(dump(outputClassName, "bootstrap", "()V"));
        }
    }

    public static byte[] dump(String outputClassName, String bsmName, String targetMethodDescriptor)
            throws Exception {
        final ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;

        // 为引导类搭建基本的元数据
        cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, outputClassName, null, "java/lang/Object", null);

        // 创建标准的void构造器
        mv = cw.visitMethod(ACC_PUBLIC, "", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "", "()V");
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        // 创建标准的main方法*
        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
                MethodType.class);
        Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, "/Users/mr-kangaroo/git/Algorithms/src/com/mr/kangaroo/klasscode/InvokeDynamicCreator", bsmName,
                mt.toMethodDescriptorString());
        mv.visitInvokeDynamicInsn("runDynamic", targetMethodDescriptor, bootstrap);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 1);
        mv.visitEnd();

        cw.visitEnd();

        return cw.toByteArray();
    }

    private static void targetMethod() {
        System.out.println("Hello World!");
    }

    public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        // 需要使用lookupClass()，因为这个方法是静态的
        final Class currentClass = lookup.lookupClass();
        final MethodType targetSignature = MethodType.methodType(void.class);
        final MethodHandle targetMH = lookup.findStatic(currentClass, "targetMethod", targetSignature);
        return new ConstantCallSite(targetMH.asType(type));
    }
}
