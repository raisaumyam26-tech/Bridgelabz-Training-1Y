
    class Delivery extends Checkpoint {
        public Delivery(String id, String loc, double dist, double exp, double act) {
            super(id, loc, dist, exp, act);
        }

        public boolean isCritical() {
            return true;
        }

        public String getType() {
            return "DeliveryCheckpoint";
        }

        public double calculatePenalty() {
            if (isDelayed()) {
                return (actualDuration - expectedDuration) * 2;
            }
            return 0.0;
        }
    }
