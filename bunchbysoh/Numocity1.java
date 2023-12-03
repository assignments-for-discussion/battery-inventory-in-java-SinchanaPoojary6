package bunchbysoh;

public class Numocity1 {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();

        int ratedCapacity = 120;

        for (int presentCapacity : presentCapacities) {
            double sohPercentage = (presentCapacity * 100.0) / ratedCapacity;

            // Classify based on SoH
            if (sohPercentage > 80) {
                counts.healthy++;
            } else if (sohPercentage >= 62) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }

        return counts;
    }

    static void testBucketingByHealth() {
        System.out.println("Counting batteries by SoH...\n");
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);
        assert counts.healthy == 2;
        assert counts.exchange == 3;
        assert counts.failed == 1;
        System.out.println("Done counting :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
