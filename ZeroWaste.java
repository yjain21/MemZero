import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.text.DecimalFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author Yash Jain Determine Big O;
 */
public class ZeroWaste {

    protected Shell shell;
    private Text codeUser;
    protected String code;
    private int userBigO;
    private int comptuerBigO;
    protected int question1;
    private Table table;
    private TableItem item;

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            ZeroWaste window = new ZeroWaste();
            window.open();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setSize(500, 500);
        shell.setText("CPU Load Analysis");
        MessageBox dialog = new MessageBox(shell,
                    SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
        dialog.setText("Check your code");
        dialog.setMessage("Your Code Needs more Variables. Try again.");

        codeUser = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP
                    | SWT.V_SCROLL);

        codeUser.setBounds(65, 119, 365, 176);

        Label lblTypeYourCode = new Label(shell, SWT.NONE);
        lblTypeYourCode.setFont(SWTResourceManager.getFont("Segoe UI", 10,
                    SWT.NORMAL));
        lblTypeYourCode.setBounds(10, 92, 200, 21);
        lblTypeYourCode.setText("Type your Code Below:");

        Label problemChoice = new Label(shell, SWT.NONE);
        problemChoice.setBounds(10, 10, 464, 76);
        problemChoice.setText(
                    "Choose which challenge you would like to attempt.");
        Label lblYourBigO = new Label(shell, SWT.NONE);
        lblYourBigO.setFont(SWTResourceManager.getFont("Segoe UI", 11,
                    SWT.BOLD));
        lblYourBigO.setBounds(20, 339, 180, 26);
        lblYourBigO.setText("Items on The Stack:");

        Label lblWhatMostEfficient = new Label(shell, SWT.NONE);
        lblWhatMostEfficient.setText("The most Efficient Stack:");
        lblWhatMostEfficient.setFont(SWTResourceManager.getFont("Segoe UI", 11,
                    SWT.BOLD));
        lblWhatMostEfficient.setBounds(20, 378, 250, 26);

        Label userBigOValue = new Label(shell, SWT.NONE);
        userBigOValue.setFont(SWTResourceManager.getFont("Segoe UI", 11,
                    SWT.BOLD));
        userBigOValue.setBounds(276, 339, 69, 21);
        userBigOValue.setText("");

        Label actualBigO = new Label(shell, SWT.NONE);
        actualBigO.setFont(SWTResourceManager.getFont("Segoe UI", 11,
                    SWT.BOLD));
        actualBigO.setBounds(276, 378, 69, 21);
        actualBigO.setText("");

        Label percentage = new Label(shell, SWT.NONE);
        percentage.setAlignment(SWT.CENTER);
        percentage.setFont(SWTResourceManager.getFont("Segoe UI", 15,
                    SWT.BOLD));
        percentage.setBounds(770, 351, 258, 46);

        Button btnDone = new Button(shell, SWT.NONE);
        btnDone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                code = codeUser.getText();
                shell.setSize(1000, 500);
                userBigO = parseValue(code);
                if (question1 == 1) {
                    comptuerBigO = 2;
                    actualBigO.setText("2");
                }
                if (question1 == 2) {
                    comptuerBigO = 1;
                    actualBigO.setText("" + comptuerBigO);
                }
                if (question1 == 3) {
                    comptuerBigO = 4;
                    actualBigO.setText("4");
                }
                if (userBigO == 0) {

                }
                else if (userBigO == 1) {
                    userBigOValue.setText("1");
                }
                else {

                    userBigOValue.setText("" + userBigO);
                    if (question1 == 3) {
                        userBigO -= 3;
                        userBigOValue.setText("" + userBigO);
                    }
                }

            }
        });
        btnDone.setBounds(366, 301, 108, 26);
        btnDone.setText(" Done!");

        btnDone.setBackground(
                    Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));

        Button questionOne = new Button(shell, SWT.NONE);
        questionOne.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                question1 = 1;
                actualBigO.setText("");
                userBigOValue.setText("");
                shell.setSize(500, 500);
                problemChoice.setText(
                            "Find the middle of a given linked list."
                                        + "Method header should be\n"
                                        + "printMiddle() and take no parameters");
            }
        });
        questionOne.setBounds(10, 301, 85, 26);
        questionOne.setText("Challenge 1");
        questionOne.setBackground(
                    Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));

        Button questionTwo = new Button(shell, SWT.NONE);
        questionTwo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                question1 = 2;

                actualBigO.setText("");
                userBigOValue.setText("");
                shell.setSize(500, 500);
                problemChoice.setText(
                            "Reverse any Linked list. Method header should be\n"
                                        + "reverse and take no parameters");
            }
        });
        questionTwo.setBounds(101, 301, 85, 26);
        questionTwo.setText("Challenge 2");
        questionTwo.setBackground(
                    Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));

        Button questionThree = new Button(shell, SWT.NONE);
        questionThree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                question1 = 3;
                shell.setSize(500, 500);
                actualBigO.setText("");
                userBigOValue.setText("");
                problemChoice.setText(
                            "Maximum sum such that no two elements are adjacent\n"
                                        + "int FindMaxSum(int arr[], int n)  is your method "
                                        + "header.");
            }
        });
        questionThree.setBounds(192, 301, 85, 26);
        questionThree.setText("Challenge 3");
        questionThree.setBackground(
                    Display.getCurrent().getSystemColor(SWT.COLOR_MAGENTA));

        Button analysisData = new Button(shell, SWT.NONE);

        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(490, 63, 482, 254);

        analysisData.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                Rectangle bounds = table.getBounds();
                table.redraw(bounds.x, bounds.y, bounds.width, bounds.height,
                            true);
                table.removeAll();
                table.setHeaderVisible(true);
                table.setLinesVisible(true);

                TableColumn tblclmnTerms = new TableColumn(table, SWT.NONE);
                tblclmnTerms.setResizable(false);
                tblclmnTerms.setMoveable(true);
                tblclmnTerms.setWidth(120);
                tblclmnTerms.setText("Runs");

                TableColumn tblclmnCost = new TableColumn(table, SWT.NONE);
                tblclmnCost.setResizable(false);
                tblclmnCost.setMoveable(true);
                tblclmnCost.setWidth(120);
                tblclmnCost.setText("Your CPU Load");

                TableColumn tblclmnUser = new TableColumn(table, SWT.NONE);
                tblclmnUser.setResizable(false);
                tblclmnUser.setMoveable(true);
                tblclmnUser.setWidth(120);
                tblclmnUser.setText("Your CPU");

                TableColumn tblclmnActual = new TableColumn(table, SWT.NONE);
                tblclmnActual.setResizable(false);
                tblclmnActual.setMoveable(true);
                tblclmnActual.setWidth(120);
                tblclmnActual.setText("Efficient CPU");

                DecimalFormat df = new DecimalFormat("###.##");
                int counter = 1;
                double costPerTerm = .15;
                double percentageExcess = 0;

                float actual = Integer
                            .parseInt(actualBigO.getText());
                float user = Integer.parseInt(userBigOValue.getText());
                while (counter < 100) {
                    item = new TableItem(table, SWT.NONE);
                    double computerEff = 1;
                    double yourEff = (int) Math.pow(counter, userBigO);

                    if (actual == user) {
                        item.setText(0, "" + counter);
                        item.setText(1, "" + Math.ceil(yourEff));
                        item.setText(2, "$" + .15);
                        item.setText(3, "$" + .15);
                    }
                    else if (comptuerBigO == 3) {
                        item.setText(0, "" + counter);
                        item.setText(1, "" + Math.ceil(yourEff));
                        item.setText(2, "$" + df.format(yourEff * costPerTerm));
                        item.setText(3, "$" + .15);
                    }

                    else {
                        computerEff = (int) Math.pow(counter, comptuerBigO);

                        item.setText(0, "" + counter);
                        item.setText(1, "" + Math.ceil(yourEff));
                        item.setText(2, "$" + df.format(yourEff * costPerTerm));
                        item.setText(3, "$" + Math.ceil(computerEff
                                    * costPerTerm));
                    }
                    percentageExcess = (double) ((yourEff * costPerTerm)
                                / (computerEff * costPerTerm));
                    counter = counter + 10;
                }

                if (percentageExcess == 1) {

                    percentage.setText("" + 0 + "%");
                }
                else {

                    float nP = actual / user;
                    nP = 1 - nP;
                    nP *= 100;
                    if (nP < 0) {
                        dialog.open();
                        shell.setSize(500, 500);

                        actualBigO.setText("");
                        userBigOValue.setText("");
                    }
                    percentage.setText("" + df.format(nP) + "%");
                }
            }
        });
        analysisData.setFont(SWTResourceManager.getFont("Segoe UI", 12,
                    SWT.BOLD));
        analysisData.setBounds(644, 10, 190, 36);
        analysisData.setText("CPU Cost");

        Label lblCostPerTerm = new Label(shell, SWT.NONE);
        lblCostPerTerm.setAlignment(SWT.CENTER);
        lblCostPerTerm.setBounds(840, 19, 134, 36);
        lblCostPerTerm.setText("Cost Per Run: $.15");

        Label Precentage = new Label(shell, SWT.NONE);
        Precentage.setFont(SWTResourceManager.getFont("Segoe UI", 13,
                    SWT.BOLD));
        Precentage.setAlignment(SWT.CENTER);
        Precentage.setBounds(534, 339, 250, 65);
        Precentage.setText("Extra Load on CPU (%):  ");

    }

    /**
     * @param textUser This is the text that is being read for the number of
     * times that has for or while
     * @return int This is the bigO value just based on the the for/while loops
     */
    public static int parseValue(String textUser) {
        int count = 0;
        textUser = textUser.toLowerCase();

        String tempDecreaseFor = textUser;
        int index = textUser.indexOf("node ");
        while (index != -1) {
            count++;
            tempDecreaseFor = tempDecreaseFor.substring(index + 1);
            index = tempDecreaseFor.indexOf("node ");
        }

        String tempDecreaseFor2 = textUser;
        int index2 = textUser.indexOf("Node ");
        while (index2 != -1) {
            count++;
            tempDecreaseFor2 = tempDecreaseFor2.substring(index2 + 1);
            index2 = tempDecreaseFor2.indexOf("Node ");
        }

        String tempDecreaseWhile = textUser;
        int index3 = textUser.indexOf("String ");
        while (index3 != -1) {
            count++;
            tempDecreaseWhile = tempDecreaseWhile.substring(index3 + 1);
            index3 = tempDecreaseWhile.indexOf("String ");
        }

        String tempDecreaseWhile2 = textUser;
        int index4 = textUser.indexOf("string ");
        while (index4 != -1) {
            count++;
            tempDecreaseWhile2 = tempDecreaseWhile2.substring(index4 + 1);
            index4 = tempDecreaseWhile2.indexOf("string ");
        }

        String t1 = textUser;
        int index6 = textUser.indexOf("int ");
        while (index6 != -1) {
            count++;
            t1 = t1.substring(index6 + 1);
            index6 = t1.indexOf("int ");
        }

        String t2 = textUser;
        int index7 = textUser.indexOf("Int ");
        while (index7 != -1) {
            count++;
            t2 = t2.substring(index7 + 1);
            index7 = t2.indexOf("Int ");
        }
        return count; 

    }
}
