package com.mr.kangaroo.allocation;

/**
 * 将一堆水果分配给一群人，是每个人分的的水果相差不多，可以指定分配水果的粒度；
 *
 * @author mr-kangaroo
 */
public class AllocationNum {
    /**
     * @param apples         总的水果数；
     * @param persons        需要分配的人数；
     * @param allocateFactor 分配水果的最小单位，1个或者是半个；
     */
    public static double allocateTheNum(double apples, int persons, double allocateFactor) {
        double deservedApple = 0;
        if (apples % persons == 0) {
            deservedApple = (int) apples / persons;
        } else {
            int _averageApple = (int) apples / persons;
            if ((_averageApple + allocateFactor) * persons > apples) {
                deservedApple = _averageApple;
            } else {
                deservedApple = _averageApple + allocateFactor;
            }
            double meanApples = apples - deservedApple * persons;
            System.out.println("==averageApple==" + deservedApple + "==meanApples==" + meanApples);
        }
        return deservedApple;
    }

    public static void main(String[] args) {
        allocateTheNum(100d, 34, 0.5);
    }
}
