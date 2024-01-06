package org.example.CopyDeep;

public class CopyObj {
    private String abc;
    private String def;
    private String ghi;

    private CopyObj(Builder builder) {}

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CopyObj copyObj) {
        return new Builder(copyObj);
    }

    public static class Builder{
        private String abc;
        private String def;
        private String ghi;

        public Builder() {}
        public Builder(CopyObj copyObj) {
            this.abc = copyObj.abc;
            this.def = copyObj.def;
            this.ghi = copyObj.ghi;
        }

        public Builder abc(String abc) {
            this.abc = abc;
            return this;
        }

        public Builder def(String def) {
            this.def = def;
            return this;
        }

        public Builder ghi(String ghi) {
            this.ghi = ghi;
            return this;
        }

        public CopyObj build() {
            return new CopyObj(this);
        }
    }
}
