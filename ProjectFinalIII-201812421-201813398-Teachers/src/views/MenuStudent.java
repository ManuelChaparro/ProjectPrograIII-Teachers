package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Event;

public class MenuStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel menuAddCourse, menuModifyCourse, menuDeleteCourse;
	private ButtonObj addCourseBtn, modifyCourseBtn, deleteCourseBtn;

	public MenuStudent(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT));
		initApp(actionListener);
	}

	private void initApp(ActionListener actionListener) {
		initLogoApp();
		initAddCourse(actionListener);
		initModifyCourse(actionListener);
		initDeleteCourse(actionListener);
	}

	private void initLogoApp() {
		createLogoImg();
		createNameApp();
	}

	private void createLogoImg() {
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(ConstantsGUI.DARK_BLUE);
		JLabel logoApp = new JLabel();
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)).getImage()
				.getScaledInstance(ConstantsGUI.WIDTH / 7, ConstantsGUI.WIDTH / 7, Image.SCALE_SMOOTH));
		logoApp.setIcon(img);
		panelLogo.add(logoApp);
		add(panelLogo);
	}

	private void createNameApp() {
		JPanel panelName = new JPanel();
		panelName.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.WHITE));
		panelName.setBackground(Color.WHITE);
		JLabel nameApp = new JLabel(ConstantsGUI.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.BOLD, ConstantsGUI.WIDTH / 40));
		nameApp.setForeground(ConstantsGUI.DARK_BLUE);
		panelName.add(nameApp);
		add(panelName);
	}

	private void initAddCourse(ActionListener actionListener) {
		menuAddCourse = new JPanel();
		menuAddCourse.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuAddCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn = new ButtonObj(ConstantsGUI.BT_ADD_COURSE_ST, actionListener, Event.ADD_COURSE_TH.toString());
		addCourseBtn.setBorder(null);
		menuAddCourse.add(addCourseBtn);
		add(menuAddCourse);
	}

	private void initModifyCourse(ActionListener actionListener) {
		menuModifyCourse = new JPanel();
		menuModifyCourse.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuModifyCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn = new ButtonObj(ConstantsGUI.BT_MODIFY_COURSE_TH, actionListener,
				Event.MODIFY_COURSE_TH.toString());
		modifyCourseBtn.setBorder(null);
		menuModifyCourse.add(modifyCourseBtn);
		add(menuModifyCourse);
	}

	private void initDeleteCourse(ActionListener actionListener) {
		menuDeleteCourse = new JPanel();
		menuDeleteCourse.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuDeleteCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn = new ButtonObj(ConstantsGUI.BT_DELETE_COURSE_ST, actionListener,
				Event.DELETE_COURSE_OR_HOMEWORK.toString());
		deleteCourseBtn.setBorder(null);
		menuDeleteCourse.add(deleteCourseBtn);

		add(menuDeleteCourse);
	}

	public void enableAddCourse(boolean isEnable) {
		addCourseBtn.setEnabled(isEnable);
	}

	public void changeColorMenuBtn(Event event) {
		switch (event) {
		case SHOW_SCHEDULE:
			changeColorShowSchedulerBtn();
			break;
		case ADD_COURSE_TH:
			changeColorAddCourseBtn();
			break;
		case MODIFY_COURSE_TH:
			changeColorModifyCourseBtn();
			break;
		case DELETE_COURSE_OR_HOMEWORK:
			changeColorDeleteCourseBtn();
			break;
		case ADD_OR_MOD_ACTIVITY_ST:
			changeColorAddActivityBtn();
			break;
		case AVG_ST:
			changeColorModifyActivityBtn();
			break;
		case DELETE_ACTIVITY_ST:
			changeColorDeleteActivityBtn();
			break;
		default:
			break;
		}
	}

	private void changeColorShowSchedulerBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorDeleteActivityBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorModifyActivityBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorAddActivityBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorDeleteCourseBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_YELLOW);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_YELLOW);
	}

	private void changeColorModifyCourseBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_YELLOW);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorAddCourseBtn() {
		menuAddCourse.setBackground(ConstantsGUI.DARK_YELLOW);
		addCourseBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}
}