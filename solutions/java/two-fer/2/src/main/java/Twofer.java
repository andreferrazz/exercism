class Twofer {
    String twofer(String name) {
	name = (name == null) ? "you" : name;
	return "One for ".concat(name).concat(", one for me.");
    }
}
