package service;

import dao.Userdao;
import dto.Task;
import dto.Userdto;
import helper.AES;

public class UserService {
	public int saveUser(Userdto dto) {
		if (dto.getAge() < 18) {
			return 0;
		} else {
			Userdao dao = new Userdao();
			Userdto dto1 = dao.findBYEmail(dto.getEmail());
			if (dto1 == null) {
				dto.setPassword(AES.encrypt(dto.getPassword(), "123"));
				dao.addUser(dto);
				return 1;
			} else {
				return 2;
			}

		}
	}

	public boolean login(String email, String password) {
		Userdao userdao = new Userdao();
		Userdto userdto = userdao.findBYEmail(email);
		if (userdto == null) {
			return false;
		} else {
			if (password.equals(AES.decrypt(userdto.getPassword(), "123"))) {
				return true;
			} else {
				return false;
			}
		}

	}

	public void saveTask(Task task) {
		Userdao userdao = new Userdao();
		userdao.saveTask(task);
	}

	public void updateUser(Userdto dto) {
		Userdao dao = new Userdao();
		dao.updateUser(dto);
	}

	public void changeStatus(int id) {
		Userdao dao = new Userdao();
		Task task = dao.findTaskByID(id);
		task.setStatus(true);
		dao.updateTask(task);

	}

	public void deleteTask(int id, Userdto dto) {
		Userdao dao = new Userdao();
		Task task = dao.findTaskByID(id);
		if (task != null) {
			// removing mapped data
			dto.getTasks().remove(task);
			dao.updateUser(dto);
			// remove task
			dao.deleteTask(task, id);
		}
	}

}
