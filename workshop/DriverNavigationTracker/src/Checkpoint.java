
    abstract class Checkpoint {
        String checkpointId;
        String locationName;
        double distanceFromLast;
        double expectedDuration;
        double actualDuration;

        public Checkpoint(String id, String loc, double dist, double exp, double act) {
            checkpointId = id;
            locationName = loc;
            distanceFromLast = dist;
            expectedDuration = exp;
            actualDuration = act;
        }

        public boolean isDelayed() {
            return actualDuration > expectedDuration;
        }

        abstract boolean isCritical();
        abstract String getType();
        abstract double calculatePenalty();
    }

