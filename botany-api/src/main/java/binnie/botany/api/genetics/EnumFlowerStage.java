package binnie.botany.api.genetics;

import forestry.api.genetics.ISpeciesType;

public enum EnumFlowerStage implements ISpeciesType {
	FLOWER("Flower"),
	SEED("Seed"),
	POLLEN("Pollen");

	public static final EnumFlowerStage[] VALUES = values();
	private final String name;

	EnumFlowerStage(String name) {
		this.name = name;
	}

	public static EnumFlowerStage getStage(IFlower flower) {
		return getStage(flower.getAge());
	}

	public static EnumFlowerStage getStage(int age) {
		return age == 0 ? EnumFlowerStage.SEED : EnumFlowerStage.FLOWER;
	}

	public String getName() {
		return name;
	}

}
