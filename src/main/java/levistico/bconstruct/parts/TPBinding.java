package levistico.bconstruct.parts;

import levistico.bconstruct.utils.Pair;

public class TPBinding extends BToolPart {

    public TPBinding(int i) {
        super(i, "Binding", EToolPart.binding, PartFlags.BINDING, 1, true, new Pair<>(1,3));
    }
}
