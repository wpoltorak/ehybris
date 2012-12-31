package com.lambda.plugin.ui;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class InputDialogWithToggle extends InputDialog {

  /**
   * The toggle button (widget). This value is <code>null</code> until the
   * dialog is created.
   */
  private Button toggleButton = null;

  /**
   * The message displayed to the user, with the toggle button. This is the
   * text besides the toggle. If it is <code>null</code>, this means that
   * the default text for the toggle should be used.
  **/
  private String toggleMessage;

  /**
   * The initial selected state of the toggle.
   */
  private boolean toggleState;

  public InputDialogWithToggle(Shell parentShell, String dialogTitle, String dialogMessage, String initialValue, IInputValidator validator,
      String toggleMessage, boolean toggleState) {
    super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
    this.toggleMessage = toggleMessage;
    this.toggleState = toggleState;
  }

  protected Button createToggleButton(Composite parent) {
    final Button button = new Button(parent, SWT.CHECK | SWT.LEFT);

    GridData data = new GridData(SWT.NONE);
    data.horizontalSpan = 2;
    button.setLayoutData(data);
    button.setFont(parent.getFont());

    button.addSelectionListener(new SelectionAdapter() {

      public void widgetSelected(SelectionEvent e) {
        toggleState = button.getSelection();
      }

    });

    return button;
  }

  /**
   * @see Dialog#createDialogArea(Composite)
   */
  protected Control createDialogArea(Composite parent) {
      Composite dialogAreaComposite = (Composite) super
              .createDialogArea(parent);
      setToggleButton(createToggleButton(dialogAreaComposite));
      return dialogAreaComposite;
  }
  
  /**
   * Returns the toggle button.
   * 
   * @return the toggle button
   */
  protected Button getToggleButton() {
      return toggleButton;
  }
  
  /**
   * A mutator for the button providing the toggle option. If the button
   * exists, then it will automatically get the text set to the current toggle
   * message, and its selection state set to the current selection state.
   * 
   * @param button
   *            The button to use; must not be <code>null</code>.
   */
  protected void setToggleButton(Button button) {
      if (button == null) {
          throw new NullPointerException(
                  "A message dialog with toggle may not have a null toggle button.");} //$NON-NLS-1$

      if (!button.isDisposed()) {
          final String text;
          if (toggleMessage == null) {
              text = JFaceResources
                      .getString("MessageDialogWithToggle.defaultToggleMessage"); //$NON-NLS-1$
          } else {
              text = toggleMessage;
          }
          button.setText(text);
          button.setSelection(toggleState);
      }

      this.toggleButton = button;
  }
  
  /**
   * A mutator for the text on the toggle button. The button will
   * automatically get updated with the new text, if it exists.
   * 
   * @param message
   *            The new text of the toggle button; if it is <code>null</code>,
   *            then used the default toggle message.
   */
  protected void setToggleMessage(String message) {
      this.toggleMessage = message;

      if ((toggleButton != null) && (!toggleButton.isDisposed())) {
          final String text;
          if (toggleMessage == null) {
              text = JFaceResources
                      .getString("MessageDialogWithToggle.defaultToggleMessage"); //$NON-NLS-1$
          } else {
              text = toggleMessage;
          }
          toggleButton.setText(text);
      }
  }
  
  /**
   * Returns the toggle state. This can be called even after the dialog is
   * closed.
   * 
   * @return <code>true</code> if the toggle button is checked,
   *         <code>false</code> if not
   */
  public boolean getToggleState() {
      return toggleState;
  }
  
  /**
   * A mutator for the state of the toggle button. This method will update the
   * button, if it exists.
   * 
   * @param toggleState
   *            The desired state of the toggle button (<code>true</code>
   *            means the toggle should be selected).
   */
  public void setToggleState(boolean toggleState) {
      this.toggleState = toggleState;

      // Update the button, if it exists.
      if ((toggleButton != null) && (!toggleButton.isDisposed())) {
          toggleButton.setSelection(toggleState);
      }
  }
  
}
