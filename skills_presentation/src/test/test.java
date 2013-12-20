package test;

import java.util.ArrayList;

import fr.skills_dao_impl.DAOException;
import fr.skills_dao_int.DAOAbstractFactory;
import fr.skills_dao_int.FactoryDAO;
import fr.skills_dto.TaskDTO;
import fr.skills_service_impl.TaskService;

public class test {

	public static void main(String[] args) throws DAOException
	{
		FactoryDAO afd = DAOAbstractFactory.getFactory(DAOAbstractFactory.DAO_FACTORY);

		TaskService taskService = new TaskService(afd);
		// ProjectService projectService = new ProjectService();
		// projectService.create(new ProjectDTO(null, "Project 1"));

		// TaskDTO aTask = new TaskDTO();
		// aTask.setEstimatedDurationTask((long) 179555515);
		// aTask.setIdProjet(1);
		// aTask.setNameTask("AZEZDE");
		// aTask.setStatusTask(Status.Annuler);
		// taskService.create(aTask);

		ArrayList<TaskDTO> aListeTask = (ArrayList<TaskDTO>) taskService.findAll();

		System.out.println(aListeTask.size());
	}
}
