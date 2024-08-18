public class Cargo {

    private final double gabarites; // Габариты
    private final double weight;//  масса
    private final String deliveryAdress;
    private final String itemPropetry; // свойство груза
    private final String registrationNumber; // регистрациооный номер
    private final boolean fragile;
    private final  boolean canFlip;// хрупкий или нет

    public Cargo(double gabarites, double weight, String deliveryAdress, String itemPropetry, String registrationNumber, boolean fragile, boolean canFlip) {
        this.gabarites = gabarites;
        this.weight = weight;
        this.deliveryAdress = deliveryAdress;
        this.itemPropetry = itemPropetry;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
        this.canFlip = canFlip;
    }



    public double getGabarites() {
        return gabarites;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public String getItemPropetry() {
        return itemPropetry;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isCanFlip() {
        return canFlip;
    }

    public boolean isFragile() {
        return fragile;
    }

     public Cargo setGabarites(double gabarites) {
         return new Cargo(gabarites, weight, deliveryAdress, itemPropetry, registrationNumber, fragile, canFlip);
    }

    public Cargo setWeight(double weight) {
        return new Cargo(gabarites, weight, deliveryAdress, itemPropetry, registrationNumber, fragile, canFlip);
    }

    public Cargo setDeliveryAdress(String deliveryAdress) {
        return new Cargo(gabarites, weight, deliveryAdress, itemPropetry, registrationNumber, fragile, canFlip);
    }

    public Cargo setItemPropetry(String itemPropetry) {
        return new Cargo(gabarites, weight, deliveryAdress, itemPropetry, registrationNumber, fragile, canFlip);
    }

    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(gabarites, weight, deliveryAdress, itemPropetry, registrationNumber, fragile, canFlip);
    }

    public Cargo setFragile(boolean fragile) {
        return new Cargo(gabarites, weight, deliveryAdress, itemPropetry, registrationNumber, fragile, canFlip);
    }

        public String toString () {
            return "Габариты груза:" + gabarites + "\n" + "Масса: " + weight + "\n" + "Адрес доставки: " + deliveryAdress +
                    "\n" + "Свойство груза: " + itemPropetry + "\n" + "Регистрациооный номер: " + registrationNumber + "\n"
                    + "Хрупкий ли груз: " + fragile;
        }

}
