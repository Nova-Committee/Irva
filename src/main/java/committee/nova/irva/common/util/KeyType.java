package committee.nova.irva.common.util;

public enum KeyType {
    BELIEF_NAME("irva.belief.", ".name"),
    BELIEF_ATTRIBUTE("irva.belief.", ".attribute");

    private final String prefix;
    private final String suffix;

    KeyType(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
