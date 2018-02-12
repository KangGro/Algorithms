package com.mr.kangaroo.loadBalance;

import com.google.common.collect.ImmutableList;
import com.mr.kangaroo.utils.MD5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/**
 * 一致性Hash算法
 *
 * @author admin
 */
public class ConsistanceHash {
    static int MAX_HASH_LENGTH = Integer.MAX_VALUE;
    static List<String> nodes = ImmutableList.of("172.168.98.69", "172.168.98.70", "172.168.98.71", "172.168.98.42");
    static TreeMap<Long, String> hashMap = new TreeMap<Long, String>();
    //添加虚拟节点
    static final int NODE_NUM = 2;

    static {
        for (Iterator<String> iterator = nodes.iterator(); iterator.hasNext(); ) {
            String serverNode = iterator.next();
            for (int i = 0; i < NODE_NUM; i++) {
                hashMap.put(hash(serverNode + "-" + i), serverNode);
            }
            hashMap.put(hash(serverNode), serverNode);
        }
        System.out.println("=====" + Arrays.toString(hashMap.keySet().toArray()));
    }

    public static int getHashIndex(String key) {
        if (key == null) {
            long hashCode = hash(key);
            SortedMap<Long, String> tmp = hashMap.tailMap(hashCode);
            //查找对应位置
            long selectedHashCode = hashMap.firstKey();

            if (tmp.isEmpty()) {
                selectedHashCode = hashMap.firstKey();
            } else {
                selectedHashCode = tmp.firstKey();
            }

            System.out.println(hashCode + "======" + hashMap.get(selectedHashCode));
            return nodes.indexOf(hashMap.get(selectedHashCode));
        }
        return 0;
    }


    /**
     * MurMurHash算法，是非加密HASH算法，性能很高，
     * 比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免）
     * 等HASH算法要快很多，而且据说这个算法的碰撞率很低.
     * http://murmurhash.googlepages.com/
     */
    private static long hash(String key) {
        //信息摘要
        key = MD5.getSecurityKey(key);
        System.out.println("====" + key);
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:   
            // finish.position(8-buf.remaining());   
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }

    public static void main(String[] args) {
        getHashIndex("workLibraryId");
        getHashIndex("aaasasfd");
        getHashIndex("uhjjgf");
        getHashIndex("okjhjjhh");
    }
}
