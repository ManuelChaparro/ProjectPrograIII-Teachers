package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import models.User;
import net.Conection;
import views.ConstantsGUI;
import views.JWindow;

public class Controller implements ActionListener {

	private JWindow window;
	private Conection conection;
	private String name;

	public Controller() {
		conection = new Conection();
		window = new JWindow(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case HIDE_PASSWORD:
			window.hidePassword();
			break;
		case LOGIN_ACCOUNT:
			window.loginAccount();
			break;
		case GET_LOGIN_DATA:
			actionGetLoginData();
			break;
		case GET_CREATE_DATA:
			actionGetCreateData();
			break;
		case CANCEL_NEW_ACCOUNT:
			window.resetLogin();
			break;
		case ADD_COURSE_TH:
			actionAddCourseTh();
			break;
		case ADD_SCHEDULE_COURSE:
			addScheduleToField();
			break;
		case BTN_COURSE:
			showConfirmCourse(true);
			break;
		case VISIBLE_CONF_COURSE:
			showConfirmCourse(false);
			break;
		case INSERT_COURSE:
			actionInsertCourse();
			break;
		case MODIFY_COURSE_TH:
			actionModifyCourseSt();
			break;
		case VISIBLE_MOD_COURSE:
			window.showModifyCourse(false);
			break;
		case BTN_MODIFY:
			setModifyData();
			break;
		case CONFIRM_MODIFY_COURSE_TH:
			actionModifyCourse();
			break;
		case DELETE_SCHEDULE_COURSE:
			clearScheduleModify();
			break;
		case DELETE_COURSE_BTN:
			actionDeleteCourse();
			break;
		case VISIBLE_DELETE_COURSE_BTN:
			window.setVisibleDeleteCourse(true);
			break;
		case VISIBLE_DELETE_COURSE_BOX:
			window.setVisibleDeleteCourse(false);
			break;
		case CONFIRM_DELETE_COURSE:
			actionConfirmDeleteCourse();
			break;
		}
	}

	private void actionModifyCourse() {
		try {
			conection.sendUTF(ConstantsCnt.CONFIRM_MODIFY_COURSE_TH_TEXT_SUBCOMMAND);
			conection.sendUTF(name + ConstantsGUI.SEPARATOR_THREE_DOT_AND_COMA + window.getModifyCourse());
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.SUCCESS_MESSAGE_COURSE_INSCRIPTION,
						ConstantsCnt.COURSE_TEXT_TITLE, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_COURSE_INSCRIPTION,
						ConstantsCnt.COURSE_TEXT_TITLE, JOptionPane.WARNING_MESSAGE);
			}
			window.showModifyCourse(false);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void clearScheduleModify() {
		window.clearScheduleModify();
	}

	private void setModifyData() {
		try {
			window.showModifyCourse(true);
			conection.sendUTF(ConstantsCnt.GET_DATA_MODIFY_SUBCOMMAND);
			conection.sendUTF(name);
			conection.sendUTF(window.getCourseModify());
			window.setDataModify(conection.receiveUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addScheduleToField() {
		window.addScheduleToField();
	}

	private void showConfirmCourse(boolean b) {
		window.showConfirmCourse(b);
	}

	private void actionGetLoginData() {
		String data = window.getLoginData();
		if (!data.equalsIgnoreCase(ConstantsCnt.EMPTY_ORDER_TEXT)) {
			if (!window.isCreate()) {
				try {
					String[] dataUser = data.split(ConstantsCnt.COMA);
					String stringUser = ConstantsCnt.EMPTY_STRING;
					try {
						stringUser = new Gson().toJson(new User(ConstantsCnt.EMPTY_STRING, dataUser[0], dataUser[1]))
								.toString();
					} catch (Exception e2) {
						stringUser = new Gson().toJson(new User(ConstantsCnt.EMPTY_STRING, ConstantsCnt.EMPTY_STRING,
								ConstantsCnt.EMPTY_STRING)).toString();
					}
					conection.sendUTF("TEACHER");
					conection.sendBoolean(true);
					conection.sendUTF(stringUser);
					if (conection.receiveBoolean()) {
						conection.sendUTF(dataUser[0]);
						name = conection.receiveUTF();
						window.setNameUser(name);
						window.changeCard(ConstantsCnt.TEACHER_TEXT_CARDLAYOUT);
					} else {
						JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_NOT_EXIST_USER,
								ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
							ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_INPUT_CORRECT_DATA,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionGetCreateData() {
		String dataCreateLog = window.getLoginData();
		String[] dataUser = dataCreateLog.split(ConstantsCnt.COMA);
		try {
			String stringUser = new Gson().toJson(new User(dataUser[0], dataUser[1], dataUser[2])).toString();
			conection.sendUTF("TEACHER");
			conection.sendBoolean(false);
			conection.sendUTF(stringUser);
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.SUCCESS_MESSAGE_USER_CREATED, ConstantsGUI.NAME_APP,
						JOptionPane.INFORMATION_MESSAGE);
				window.resetLogin();
				window.changeCard(ConstantsCnt.LOGIN_TEXT_CARDLAYOUT);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_USER_ALREADY_EXIST,
						ConstantsGUI.NAME_APP, JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionAddCourseTh() {
		try {
			window.changeColorMenuBtn(Event.ADD_COURSE_TH);
			conection.sendUTF(ConstantsCnt.ADD_COURSE_ST_TEXT_SUBCOMMAND);
			window.resertComboBoxCourses();
			window.setComboBoxCourses(conection.receiveUTF());
			window.changeCardStudent(ConstantsCnt.ADD_COURSE_TEXT_CARDLAYOUT);
		} catch (IOException e3) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionInsertCourse() {
		try {
			conection.sendUTF(ConstantsCnt.INSERT_COURSE_TEXT_SUBCOMMAND_TH);
			conection.sendUTF(name + ConstantsGUI.SEPARATOR_THREE_DOT_AND_COMA + window.getNewCourse());
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.SUCCESS_MESSAGE_COURSE_INSCRIPTION,
						ConstantsCnt.COURSE_TEXT_TITLE, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_COURSE_INSCRIPTION,
						ConstantsCnt.COURSE_TEXT_TITLE, JOptionPane.WARNING_MESSAGE);
			}
			showConfirmCourse(false);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionModifyCourseSt() {
		try {
			window.changeColorMenuBtn(Event.MODIFY_COURSE_TH);
			conection.sendUTF(ConstantsCnt.MODIFY_COURSE_TH_TEXT_SUBCOMMAND);
			window.resertComboBoxCourses();
			conection.sendUTF(name);
			window.setComboBoxCourses(conection.receiveUTF());
			window.changeCardStudent(ConstantsCnt.MODIFY_COURSE_TEXT_CARDLAYOUT);
		} catch (IOException e3) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}


	private void actionDeleteCourse() {
		try {
			conection.sendUTF(ConstantsCnt.DELETE_COURSE_OR_HOMEWORK_TEXT_SUBCOMMAND);
			window.changeColorMenuBtn(Event.DELETE_COURSE_BTN);
			window.setVisibleConfirmDelete(false);
			window.resetComboDeleteCourses();
			conection.sendUTF(name);
			window.setComboBoxDeleteCourses(conection.receiveUTF().split(ConstantsCnt.SEPARATOR_ONE_DOT_AND_COMA));
			if (!window.getSelectedItemsCourse()) {
				window.setEditBtnDeleteCourse(false);
			} else {
				window.setEditBtnDeleteCourse(true);
			}
			window.changeCardStudent(ConstantsCnt.DELETE_COURSE_TEXT_CARDLAYOUT);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionConfirmDeleteCourse() {
		try {
			conection.sendUTF(ConstantsCnt.CONFIRM_DELETE_COURSE_TEXT_SUBCOMMAND);
			conection.sendUTF(name);
			conection.sendUTF(window.getDeleteCourse());
			window.removeSpecificCourse(window.getDeleteCourse());
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, "Se han borrado todas las asignaturas", "CANCELAR ASIGNATURA", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente", "CANCELAR ASIGNATURA", JOptionPane.INFORMATION_MESSAGE);
			}
			if (!window.getSelectedItemsCourse()) {
				window.setEditBtnDeleteCourse(false);
			} else {
				window.setEditBtnDeleteCourse(true);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}
}