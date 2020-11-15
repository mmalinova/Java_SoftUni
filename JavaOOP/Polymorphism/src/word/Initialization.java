package word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initialization {
    private static StringBuilder cutString = new StringBuilder();

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandInterface() {

            private Map<String, TextTransform> commandTransforms = new HashMap<>();

            class ToUpperTransform implements TextTransform {
                @Override
                public void invokeOn(StringBuilder text, int startIndex, int endIndex){
                    for (int i = startIndex; i < endIndex; i++) {
                        text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
                    }
                }
            }
            class CutTransform implements TextTransform {
                @Override
                public void invokeOn(StringBuilder text, int startIndex, int endIndex){
                    cutString.replace(0, cutString.length(), "");
                    cutString.append(text.substring(startIndex, endIndex));
                    text.replace(startIndex, endIndex, "");
                }
            }
            class PasteTransform implements TextTransform {
                @Override
                public void invokeOn(StringBuilder text, int startIndex, int endIndex){
                    text.replace(startIndex, endIndex, String.valueOf(cutString));
                }
            }

            @Override
            public void init() {
                this.commandTransforms.clear();
                for (Command p : this.initCommands()) {
                    this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
                }
            }

            @Override
            public void handleInput(String input) {
                this.init();

                String[] tokens = input.split("\\s+");
                String commandName = tokens[0];
                int startInd = Integer.parseInt(tokens[1]);
                int endInd = Integer.parseInt(tokens[2]);

                this.commandTransforms.get(commandName).invokeOn(text, startInd, endInd);
            }

            protected List<Command> initCommands() {
                List<Command> commands = new ArrayList<>();
                commands.add(new Command("uppercase", new ToUpperTransform()));
                commands.add(new Command("cut", new CutTransform()));
                commands.add(new Command("paste", new PasteTransform()));

                return commands;
            }
        };
    }
}
