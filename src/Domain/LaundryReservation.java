package Domain;

public class LaundryReservation {

    private Student student;
    private int floor;
    private boolean isPaid;
    private boolean isKeyReturned;
    private String machineStatus;

    private LaundryReservation(LaundryReservationBuilder builder){
        this.student = builder.student;
        this.floor = builder.floor;
        this.machineStatus = builder.machineStatus;
        this.isKeyReturned = builder.isKeyReturned;
        this.isPaid = builder.isPaid;
    }

    public void markAsPaid(){
        this.isPaid = true;
    }

    public void returnKey(){
        this.isKeyReturned = true;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isKeyReturned() {
        return isKeyReturned;
    }

    public void setKeyReturned(boolean keyReturned) {
        isKeyReturned = keyReturned;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public static class LaundryReservationBuilder {

        private Student student;
        private int floor;
        private boolean isPaid;
        private boolean isKeyReturned;
        private String machineStatus;

        public LaundryReservation build(){
            return new LaundryReservation(this);
        }


        public LaundryReservationBuilder withStudent (Student student){
            this.student = student;
            return this;
        }

        public LaundryReservationBuilder withFloor(int floor){
            this.floor = floor;
            return this;
        }

        public LaundryReservationBuilder withIsPaid(boolean isPaid){
            this.isPaid = isPaid;
            return this;
        }

        public LaundryReservationBuilder withIsKeyReturned(boolean isKeyReturned){
            this.isKeyReturned = isKeyReturned;
            return this;
        }

        public LaundryReservationBuilder withMachineStatus(String machineStatus){
            this.machineStatus = machineStatus;
            return this;
        }

    }






}
