public interface Poopable {
    void takeADump(PoopType poopType);
}

enum PoopType {
    SOLID, LIQUID, GAS
}
