package test;

public class test2 {
    public static class Shape {
        private int var1;
        public int var2;

        public int[] Arr = {0, 1, 2, 3, 4};
        public Shape setVar1(int var1) {
            return this;
        }

        private void setVar2(int var2) {
            this.var2 = var2;
        }

        public int getVar1() {
            return var1;
        }

        public int getVar2() {
            return var2;
        }

        public void add(){
            var1++;
        }
    }
}
