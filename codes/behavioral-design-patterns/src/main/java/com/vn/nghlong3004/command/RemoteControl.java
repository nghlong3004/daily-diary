package com.vn.nghlong3004.command;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class RemoteControl {
  private Command lastCommand;

  public void submit(Command command) {
    this.lastCommand = command;
    command.execute();
  }

  public void undo() {
    if (lastCommand != null) {
      lastCommand.undo();
    }
  }
}
