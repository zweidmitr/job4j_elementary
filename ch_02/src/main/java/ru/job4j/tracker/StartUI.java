package ru.job4j.tracker;

import ru.job4j.calculate.Out;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input!! You can select: 0 .. 0");
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu: ");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }

    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ShowAllItemAction(output), new ReplaceItemAction(output), new DeleteItemAction(output),
                new FindByIdAction(output), new FindByNameAction(output), new ExitProgramAction()};

        new StartUI(output).init(input, tracker, actions);
    }
}
