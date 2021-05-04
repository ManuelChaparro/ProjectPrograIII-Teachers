package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import controller.Event;

public class AddCoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course;
	private JComboBox<String> days;
	private JSpinner init, end;
	private JTextArea scheduleField, annotation;
	private ButtonObj createCourse, acceptCourse;
	private JPanel containerModify, containerSchedule, schedule;
	private ButtonObj btnAdd;

	public AddCoursePanel(ActionListener actionListener) {
		setLayout(new GridLayout(3, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initSearchComponents(actionListener);
		initModifyComponents(actionListener);
	}

	private void initSearchComponents(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(2, 1));
		containerBox.setBackground(Color.WHITE);
		createCoursesComboBox(actionListener, containerBox);
		createConfirmSearchBtn(actionListener, containerBox);
		add(containerBox);
	}

	private void createCoursesComboBox(ActionListener actionListener, JPanel containerBox) {
		course = new JComboBox<String>();
		course.addActionListener(actionListener);
		course.setActionCommand(Event.VISIBLE_CONF_COURSE.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"CURSOS", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		course.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(course);
	}

	private void createConfirmSearchBtn(ActionListener actionListener, JPanel containerBox) {
		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		createCourse = new ButtonObj("Confirmar", actionListener, Event.BTN_COURSE.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButton.add(createCourse);
		containerBox.add(containerButton);
	}

	private void initModifyComponents(ActionListener actionListener) {
		containerModify = new JPanel(new GridLayout(2, 2, 20, 20));
		containerModify.setBackground(Color.WHITE);
		createNameActivityTextField();
		createAnnotationActivityTextField();
		add(containerModify);

		createContainerScheduler(actionListener);
	}

	private void createNameActivityTextField() {
		annotation = new JTextArea();
		annotation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"DESCRIPCION DEL CURSO", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		annotation.setFont(ConstantsGUI.DEFAULT_FONT_ITALIC_MAX);
		annotation.setForeground(ConstantsGUI.DARK_BLUE);
		annotation.setBackground(Color.WHITE);
		annotation.setLineWrap(true);
		containerModify.add(annotation);
	}

	private void createAnnotationActivityTextField() {
		
		scheduleField = new JTextArea();
		scheduleField.setLineWrap(true);
		scheduleField.setFont(ConstantsGUI.DEFAULT_FONT);
		scheduleField.setForeground(Color.BLACK);
		scheduleField.setEditable(false);
		JScrollPane scroll = new JScrollPane(scheduleField);
		scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"HORARIOS ESTABLECIDOS", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		scroll.setBackground(Color.WHITE);
		
		containerModify.add(scroll);
	}

	private void createContainerScheduler(ActionListener actionListener) {
		schedule = new JPanel(new GridLayout(1, 2));
		schedule.setBackground(Color.WHITE);

		containerSchedule = new JPanel(new GridLayout(2, 1, 20, 0));
		containerSchedule.setBackground(Color.WHITE);
		containerSchedule.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1), "HORARIO DE LA ACTIVIDAD", TitledBorder.LEFT,
				TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		createDaysComboBox();
		createContainerHours(actionListener);
		schedule.add(containerSchedule);

		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		containerButton.setBorder(BorderFactory.createEmptyBorder(ConstantsGUI.HEIGHT / 20, ConstantsGUI.WIDTH / 20, 0,
				ConstantsGUI.WIDTH / 20));
		acceptCourse = new ButtonObj("Aceptar", actionListener, Event.INSERT_COURSE.toString(), ConstantsGUI.DARK_YELLOW);
		containerButton.add(acceptCourse);
		schedule.add(containerButton);

		add(schedule);
	}

	private void createDaysComboBox() {
		days = new JComboBox<String>();
		days.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		days.setBackground(Color.WHITE);
		days.setForeground(Color.BLACK);
		days.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"DIA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		for (int i = 1; i < ConstantsGUI.DAYS.length; i++) {
			days.addItem(ConstantsGUI.DAYS[i]);
		}
		containerSchedule.add(days);
	}

	private void createContainerHours(ActionListener actionListener) {
		JPanel containerHours = new JPanel(new GridLayout(1, 3));
		containerHours.setBackground(Color.WHITE);
		createInitHourSpinner(containerHours);
		createEndHourSpinner(containerHours);
		createBtnAddSchedule(containerHours, actionListener);
		init.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				end.setValue((int) init.getValue() + 1);
			}
		});
		containerSchedule.add(containerHours);
	}

	private void createBtnAddSchedule(JPanel containerHours, ActionListener actionListener) {
		JPanel panelBtn = new JPanel(new GridLayout(2, 0));
		panelBtn.setBackground(Color.WHITE);
		btnAdd = new ButtonObj("Agregar horario", actionListener, Event.ADD_SCHEDULE_COURSE.toString(), ConstantsGUI.DARK_PURPLE);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		ButtonObj btnDelete = new ButtonObj("Borrar horario", actionListener, Event.DELETE_SCHEDULE_COURSE.toString(), ConstantsGUI.DARK_RED);
		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		panelBtn.add(btnAdd);
		panelBtn.add(btnDelete);
		containerHours.add(panelBtn);
	}

	private void createInitHourSpinner(JPanel containerHours) {
		SpinnerModel modelInit = new SpinnerNumberModel(10, 6, 20, 1);
		init = new JSpinner(modelInit);
		init.setBackground(Color.WHITE);
		((DefaultEditor) init.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) init.getEditor()).getTextField().setBackground(Color.WHITE);
		init.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"HORA INICIO", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		init.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		init.setForeground(Color.GRAY);
		containerHours.add(init);
	}

	private void createEndHourSpinner(JPanel containerHours) {
		SpinnerModel modelEnd = new SpinnerNumberModel(11, 7, 21, 1);
		end = new JSpinner(modelEnd);
		end.setBackground(Color.WHITE);
		((DefaultEditor) end.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) end.getEditor()).getTextField().setBackground(Color.WHITE);
		end.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1), "HORA FIN",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		end.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		end.setForeground(Color.GRAY);
		containerHours.add(end);
	}

	public String getModActString() {
		if (!annotation.getText().equalsIgnoreCase("") && (int) end.getValue() > (int) init.getValue()) {
			return annotation.getText() + ";;;" + scheduleField.getText() + ";;;" + days.getSelectedItem().toString() + "#"
					+ init.getValue() + "#" + end.getValue();
		} else if ((int) end.getValue() <= (int) init.getValue()) {
			return "errorEnd";
		} else {
			return "emptyData";
		}

	}

	public void resetComboBoxCourses() {
		course.removeAllItems();		
	}

	public void setComboBoxCourses(String courses) {
		String[] coursesVector = courses.split(";");
		for (int i = 0; i < coursesVector.length; i++) {
			course.addItem(coursesVector[i]);
		}
	}

	public void showConfirmCourse(boolean b) {
		containerModify.setVisible(b);
		containerSchedule.setVisible(b);
		acceptCourse.setVisible(b);
		scheduleField.setText("");
		annotation.setText("");
		days.removeAllItems();
		for (int i = 1; i < ConstantsGUI.DAYS.length; i++) {
			days.addItem(ConstantsGUI.DAYS[i]);
		}
	}
	
	public void clearScheduleModify() {
		days.removeAllItems();
		for (int i = 1; i < ConstantsGUI.DAYS.length; i++) {
			days.addItem(ConstantsGUI.DAYS[i]);
		}
		scheduleField.setText("");
		days.setEnabled(true);
		btnAdd.setEnabled(true);
		btnAdd.setVisible(true);
	}

	public String getNewCourse() {
		days.removeAllItems();
		for (int i = 1; i < ConstantsGUI.DAYS.length; i++) {
			days.addItem(ConstantsGUI.DAYS[i]);
		}
		return course.getSelectedItem().toString() +ConstantsGUI.SEPARATOR_THREE_DOT_AND_COMA+ annotation.getText()
		+ConstantsGUI.SEPARATOR_THREE_DOT_AND_COMA+scheduleField.getText();
	}

	public void addScheduleToField() {
		String dataSchedule = scheduleField.getText();
		dataSchedule += days.getSelectedItem() + ":" + init.getValue() + "-" +end.getValue() + "  ->  ";
		scheduleField.setText(dataSchedule);
		if (days.getItemCount()!=1) {
			for (int i = 0; i < days.getItemCount(); i++) {
				if (days.getSelectedItem().toString().equalsIgnoreCase(days.getItemAt(i))) {
					days.removeItemAt(i);
				}			
			}
		}else {
			days.setEnabled(false);
			btnAdd.setEnabled(false);
		}
	}
}