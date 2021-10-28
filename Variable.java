public class Variable {
    public String name;
    public String id;
    public int status; // 1表示定义了，还未赋值，2表示定义了也赋值了
    public boolean isConst;

    public Variable(String name, String id, int status, boolean isConst) {
        this.name = name;
        this.id = id;
        this.status = status;
        this.isConst = isConst;
    }

    public static String getId(String name) {
        for (Variable v : Visitor.variableList) {
            if (v.name.equals(name)) {
                return v.id;
            }
        }
        return null;
    }

    public static void checkRepeat(String name) {
        for (Variable v : Visitor.variableList) {
            if (v.name.equals(name)) {
                System.exit(1);
            }
        }
    }

    public static void checkStatus(String name) {
        for (Variable v : Visitor.variableList) {
            if (v.name.equals(name) && v.status == 1) {
                System.exit(1);
            } else if (v.name.equals(name) && v.status == 2) {
                return;
            }
        }
        System.exit(1);
    }

    public static boolean isConst(String name) {
        for (Variable v : Visitor.variableList) {
            if (v.name.equals(name) && v.isConst) {
                return true;
            } else if (v.name.equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static void changeId(String name, String newId) {
        for (Variable v : Visitor.variableList) {
            if (v.name.equals(name)) {
                v.id = newId;
                v.status = 2;
            }
        }
    }
}
