class RouteLinkedList<T extends Checkpoint> {
    Node<T> head;
    public void addCheckpoint(T checkpoint) {
        Node<T> newNode = new Node<>(checkpoint);
        if (head == null) { head = newNode;
        } else { Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) {
            return false;
        }
        if (head.data.checkpointId.equals(checkpointId)) {
            head = head.next;
            return true;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.checkpointId.equals(checkpointId)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public T findCheckpoint(String checkpointId) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.checkpointId.equals(checkpointId)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public double computeTotalDistance() {
        double total = 0;
        Node<T> temp = head;
        while (temp != null) {
            total = total + temp.data.distanceFromLast;
            temp = temp.next;
        }
        return total;
    }

    public double computeTotalPenalty() {
        double total = 0;
        Node<T> temp = head;
        while (temp != null) {
            total = total + temp.data.calculatePenalty();
            temp = temp.next;
        }
        return total;
    }

    public boolean isConsistent() {
        boolean gotDelivery = false;
        boolean gotFuel = false;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.getType().equals("DeliveryCheckpoint")) {
                gotDelivery = true;
            }
            if (temp.data.getType().equals("FuelCheckpoint")) {
                gotFuel = true;
            }
            temp = temp.next;
        }
        if(gotDelivery&&gotFuel) {
            return true;
        } else {
            return false;
        }
    }

    public void printRoute() {
        Node<T> temp = head;
        int count = 1;
        while (temp != null) {
            String delayStr="On Time";
            if (temp.data.isDelayed()) {
                delayStr="Delayed";
            }
            System.out.println(count + ". " + temp.data.getType() + " - " + temp.data.locationName + " - " + delayStr + " - Penalty: " + temp.data.calculatePenalty());
            count++;
            temp = temp.next;
        }
    }
}