package com.scdevteam;

import com.scdevteam.commands.BaseCommand;
import com.scdevteam.commands.Help;
import com.scdevteam.commands.MissingParams;
import com.scdevteam.commands.Patchers;

public class CommandsHandler {

    public static BaseCommand handleCommand(String cmd) {
        String[] parts = cmd.split(" ");

        switch (parts[0]) {
            case "help":
                return new Help();
            case "patch":
                if (parts.length < 3) {
                    return new MissingParams("Usage: patch [cr - coc - bb - hh - bs] [host] [key optional]");
                }

                String key = parts.length > 3 ? parts[3] :
                        "72f1a4a4c48e44da0c42310f800e96624e6dc6a641a9d41c3b5039d8dfadc27e";
                return new Patchers(parts[1], parts[2], key);
        }

        return null;
    }
}
