package p04word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    class cutTransform implements TextTransform {

        StringBuilder buffer;

        public cutTransform(StringBuilder buffer) {
            this.buffer = buffer;
        }

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            this.buffer.setLength(0);
            this.buffer.append(text.substring(startIndex, endIndex));
            text.delete(startIndex, endIndex);
        }
    }

    class pasteTransform implements TextTransform {

        StringBuilder buffer;

        public pasteTransform(StringBuilder buffer) {
            this.buffer = buffer;
        }

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            text.replace(startIndex, endIndex, this.buffer.toString());
        }
    }

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;
    private StringBuilder buffer;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
        this.buffer = new StringBuilder("");
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        this.buffer.setLength(0);
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new cutTransform(this.buffer)));
        commands.add(new Command("paste", new pasteTransform(this.buffer)));

        return commands;
    }
}
