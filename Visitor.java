import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Visitor extends lab3BaseVisitor<Void> {
    public PrintStream ps = new PrintStream(new FileOutputStream(Test.outputPath));
    public static String exp = "";
    public static ArrayList<Variable> variableList = new ArrayList<>();
    public static int num = 0;
    public boolean endFlag = false;
    public boolean funcFlag = false;

    public Visitor() throws FileNotFoundException {
        System.setOut(ps);
    }

    // done
    @Override
    public Void visitCompUnit(lab3Parser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    // done
    @Override
    public Void visitFuncDef(lab3Parser.FuncDefContext ctx) {
        System.out.println("declare i32 @getint()");
        System.out.println("declare void @putint(i32)");
        System.out.println("declare i32 @getch()");
        System.out.println("declare void @putch(i32)");
        System.out.print("define dso_local ");
        return super.visitFuncDef(ctx);
    }

    // done
    @Override
    public Void visitFuncType(lab3Parser.FuncTypeContext ctx) {
        System.out.print("i32 @main() ");
        return null;
    }

    // done
    @Override
    public Void visitBlock(lab3Parser.BlockContext ctx) {
        System.out.println("{");
        for (lab3Parser.BlockItemContext e : ctx.blockItem()) {
            visit(e);
        }
        if (!endFlag) {
            System.out.println("    ret i32 0");
        }
        System.out.println("}");
        return null;
    }

    // done
    @Override
    public Void visitBlockItem(lab3Parser.BlockItemContext ctx) {
        return super.visitBlockItem(ctx);
    }

    @Override
    public Void visitStmt(lab3Parser.StmtContext ctx) {
        if (ctx.lVal() != null) {
            if (Variable.isConst(ctx.lVal().getText())) {
                System.exit(1);
            }
            String var = ctx.lVal().getText();
            System.out.println("    %" + (num + 1) + " = alloca i32");
            int temp = ++num;
            exp = "";
            visit(ctx.exp());
            String s = "";
            if (!funcFlag) {
                s = new PostfixExpression().func(exp);
            } else {
                s = "%" + num;
                funcFlag = false;
            }
            System.out.println("    store i32 " + s + ", i32* %" + temp);
            System.out.println("    %" + (num + 1) + " = load i32, i32* %" + temp);
            num++;
            Variable.changeId(var, "%" + num);
        } else if (ctx.return_() != null) {
            exp = "";
            visit(ctx.exp());
            String s = "";
            if (!funcFlag) {
                s = new PostfixExpression().func(exp);
            } else {
                s = "%" + num;
                funcFlag = false;
            }
            System.out.println("    ret i32 " + s);
            endFlag = true;
        } else {
            exp = "";
            visit(ctx.exp());
            String s = "";
            if (!funcFlag) {
                s = new PostfixExpression().func(exp);
            } else {
                s = "%" + num;
                funcFlag = false;
            }
        }
        return null;
    }

    //done
    @Override
    public Void visitReturn_(lab3Parser.Return_Context ctx) {
        return super.visitReturn_(ctx);
    }

    // done
    @Override
    public Void visitLVal(lab3Parser.LValContext ctx) {
        return super.visitLVal(ctx);
    }

    // done
    @Override
    public Void visitDecl(lab3Parser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    // done
    @Override
    public Void visitConstDecl(lab3Parser.ConstDeclContext ctx) {
        return super.visitConstDecl(ctx);
    }

    // done
    @Override
    public Void visitBType(lab3Parser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    /*
    %1 = alloca i32
    %2 = sub i32 123, 122
    store i32 %2, i32* %1
    %3 = load i32, i32* %1
     */
    // done
    @Override
    public Void visitConstDef(lab3Parser.ConstDefContext ctx) {
        Variable.checkRepeat(ctx.ident().getText());
        String var = ctx.ident().getText();
        System.out.println("    %" + (num + 1) + " = alloca i32");
        int temp = ++num;
        exp = "";
        visit(ctx.constInitVal());
        String s = "";
        if (!funcFlag) {
            char[] str1 = exp.toCharArray();
            for (int i = 0; i < str1.length; i++) {
                String string = "";
                boolean flag = false;
                if (Character.isLetter(str1[i]) || str1[i] == '_') {
                    string += str1[i];
                    i++;
                    flag = true;
                    for (; i < str1.length && (Character.isDigit(str1[i]) || Character.isLetter(str1[i]) || str1[i] == '_'); i++) {
                        string += str1[i];
                    }
                }
                if (flag) {
                    Variable.checkExist(string);
                    if (!Variable.isConst(string)) {
                        System.exit(1);
                    }
                    i--;
                    flag = false;
                }
            }
            s = new PostfixExpression().func(exp);
        } else {
            s = "%" + num;
            funcFlag = false;
        }
        System.out.println("    store i32 " + s + ", i32* %" + temp);
        System.out.println("    %" + (num + 1) + " = load i32, i32* %" + temp);
        num++;

        variableList.add(new Variable(var, "%" + num, 2, true));
        return null;
    }

    // done
    @Override
    public Void visitConstInitVal(lab3Parser.ConstInitValContext ctx) {
        return super.visitConstInitVal(ctx);
    }

    // done
    @Override
    public Void visitConstExp(lab3Parser.ConstExpContext ctx) {
        return super.visitConstExp(ctx);
    }

    // done
    @Override
    public Void visitVarDecl(lab3Parser.VarDeclContext ctx) {
        return super.visitVarDecl(ctx);
    }

    // done
    @Override
    public Void visitVarDef(lab3Parser.VarDefContext ctx) {
        Variable.checkRepeat(ctx.ident().getText());
        if (ctx.initVal() == null) {
            String var = ctx.ident().getText();
            System.out.println("    %" + (num + 1) + " = alloca i32");
            int temp = ++num;
            System.out.println("    %" + (num + 1) + " = load i32, i32* %" + temp);
            num++;
            variableList.add(new Variable(var, "%" + num, 1, false));
        } else {
            String var = ctx.ident().getText();
            System.out.println("    %" + (num + 1) + " = alloca i32");
            int temp = ++num;
            exp = "";
            visit(ctx.initVal());
            String s = "";
            if (!funcFlag) {
                s = new PostfixExpression().func(exp);
            } else {
                s = "%" + num;
                funcFlag = false;
            }
            System.out.println("    store i32 " + s + ", i32* %" + temp);
            System.out.println("    %" + (num + 1) + " = load i32, i32* %" + temp);
            num++;
            variableList.add(new Variable(var, "%" + num, 2, false));
        }
        return null;
    }

    // done
    @Override
    public Void visitInitVal(lab3Parser.InitValContext ctx) {
        return super.visitInitVal(ctx);
    }

    // done
    @Override
    public Void visitExp(lab3Parser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override
    public Void visitAddExp(lab3Parser.AddExpContext ctx) {
        return super.visitAddExp(ctx);
    }

    @Override
    public Void visitAddSub(lab3Parser.AddSubContext ctx) {
        exp += ctx.getText();
        return null;
    }

    @Override
    public Void visitMulExp(lab3Parser.MulExpContext ctx) {
        return super.visitMulExp(ctx);
    }

    @Override
    public Void visitMulDiv(lab3Parser.MulDivContext ctx) {
        exp += ctx.getText();
        return null;
    }

    @Override
    public Void visitUnaryExp(lab3Parser.UnaryExpContext ctx) {
        if (ctx.primaryExp() != null) {
            visit(ctx.primaryExp());
        } else if (ctx.ident() != null) {
            String func = ctx.ident().getText();
            if (func.equals("getint") || func.equals("getch") || func.equals("putint") || func.equals("putch")) {
                if (func.equals("getint") && ctx.funcRParams() == null) {
                    System.out.println("    %" + (num + 1) + " = call i32 @getint()");
                    num++;
                    funcFlag = true;
                } else if (func.equals("putint") && ctx.funcRParams() != null) {
                    exp = "";
                    visit(ctx.funcRParams());
                    String s = new PostfixExpression().func(exp);
                    System.out.println("    call void @putint(i32 " + s + ")");
                    funcFlag = true;
                } else if (func.equals("getch") && ctx.funcRParams() == null) {
                    System.out.println("    %" + (num + 1) + " = call i32 @getch()");
                    num++;
                    funcFlag = true;
                } else if (func.equals("putch") && ctx.funcRParams() != null) {
                    exp = "";
                    visit(ctx.funcRParams());
                    String s = new PostfixExpression().func(exp);
                    System.out.println("    call void @putch(i32 " + s + ")");
                    funcFlag = true;
                } else {
                    System.exit(1);
                }
            } else {
                System.exit(1);
            }
        } else {
            visit(ctx.unaryOp());
            visit(ctx.unaryExp());
        }
        return null;
    }

    @Override
    public Void visitFuncRParams(lab3Parser.FuncRParamsContext ctx) {
        return super.visitFuncRParams(ctx);
    }

    @Override
    public Void visitPrimaryExp(lab3Parser.PrimaryExpContext ctx) {
        if (ctx.exp() != null) {
            exp += "(";
            visit(ctx.exp());
            exp += ")";
        } else if (ctx.lVal() != null) {
            exp += ctx.lVal().getText();
        } else {
            visit(ctx.number());
        }
        return null;
    }

    @Override
    public Void visitUnaryOp(lab3Parser.UnaryOpContext ctx) {
        exp += ctx.getText();
        return null;
    }

    @Override
    public Void visitIdent(lab3Parser.IdentContext ctx) {
        return super.visitIdent(ctx);
    }

    @Override
    public Void visitNumber(lab3Parser.NumberContext ctx) {
        if (ctx.DecimalConst() != null) {
            exp += ctx.DecimalConst().getText();
        } else if (ctx.OctalConst() != null) {
            if (ctx.OctalConst().getText().equals("0")) {
                exp += "0";
            } else {
                String s = ctx.OctalConst().getText().substring(1);
                exp += String.valueOf(Integer.parseInt(s, 8));
            }
        } else {
            String s = ctx.HexadecimalConst().getText().substring(2);
            exp += String.valueOf(Integer.parseInt(s, 16));
        }
        return null;
    }
}
