package com.aurea.ap;

import com.aurea.ap.antlr4.JavaLexer;
import com.aurea.ap.antlr4.JavaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JavaParserTest {

    @Test
    public void testValidJavaFiles() {

        File testDirectory = new File("src/test/java/com/aurea/ap/sample/");

        listFiles(testDirectory, new Listener() {

            // Change to true when skipping files
            private boolean skip = false;

            public void enterFile(File file) {


                if (file.getName().endsWith(".java") && !skip) {

                    try {
                        System.out.println("Parsing file: " + file.getPath());

                        FileInputStream fileInputStream = new FileInputStream(file);

                        JavaLexer lex = new JavaLexer(new ANTLRInputStream(fileInputStream)); // transforms characters into tokens
                        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
                        JavaParser parser = new JavaParser(tokens); // transforms tokens into parse trees

                        ParseTree tree = parser.compilationUnit();

//                        parser.setBuildParseTree(true);
//                        ParseTree t = parser.classDeclaration().Identifier(); // creates the parse tree from the called rule
//                        System.out.println(t.getText());
//
//
//                        JavaBaseVisitor a = new JavaBaseVisitor();
//                        a.visitMethodDeclaration(parser.methodDeclaration());


                        System.out.println("done!");
                    } catch (IOException e) {
                        e.printStackTrace();
                        //fail();
                    }
                }
            }
        });

    }

    private void listFiles(File directory, Listener listener) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                listFiles(file, listener);
            } else {
                listener.enterFile(file);
            }
        }
    }

    private interface Listener {
        void enterFile(File file);
    }

}
