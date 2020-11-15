package com.picsart.Lesson4.inheritance.model;

public class Mobile extends Product {

    private final double TAX_RATE = 10;
    private String operating_system;
    private String model;
    private int memory;
    private boolean hasGuarantee;

    public Mobile(String name, String operating_system, String model, int memory, boolean hasGuarantee) {
        super(name, "Unknown", 0, 0.0, 2);
        this.operating_system = operating_system;
        this.model = model;
        this.memory = memory;
        this.hasGuarantee = hasGuarantee;
        setTax(TAX_RATE);
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public boolean isHasGuarantee() {
        return hasGuarantee;
    }

    public void setHasGuarantee(boolean hasGuarantee) {
        this.hasGuarantee = hasGuarantee;
    }

    public void repair() {
        System.out.println("mobile not working");
        if (hasGuarantee) {
            System.out.println("has guarantee ticket, will be repaired");
        } else {
            System.out.println("repair with addition money");
        }
    }


    public void dial() {
        System.out.println("Dial a number");
    }

    public void sendMessage() {
        System.out.println("Message Sent");
    }

    public void getWIFIConnection() {
        System.out.println("WIFI connected");
    }


    public void notifySupplier() {
        System.out.println("call to 010 345555");
    }

    @Override
    public void printInfo() {
        System.out.println("name: " + getName());
        System.out.println("model: " + model);
        System.out.println("price: " + sellingPrice());
    }

}
