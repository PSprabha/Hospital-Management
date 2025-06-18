package careplus.features.receptionist;

import java.util.HashMap;
import java.util.Scanner;

import careplus.Main;
import careplus.features.base.AppointmentManage;
import careplus.features.base.BaseView;
import careplus.features.base.DoctorManage;
import careplus.features.base.PatientManage;
import careplus.repository.db.HospitalRepository;
import careplus.repository.dto.Admin;

public class ReceptionistMain {

	private final Scanner scanner = new Scanner(System.in);
	private final HospitalRepository repo = HospitalRepository.getInstance();
	HashMap<Integer, Admin> admins = repo.getAllAdmin();
	
	public void showMainMenu() {
		// TODO Auto-generated method stub
		
		new BaseView().showMainMenu();
	}

}
