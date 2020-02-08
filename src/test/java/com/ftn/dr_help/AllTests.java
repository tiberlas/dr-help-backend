package com.ftn.dr_help;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ftn.dr_help.comon.automatically_reserving.CheckRoomsTest;
import com.ftn.dr_help.comon.schedule.CalculateFirstFreeOperationScheduleTest;
import com.ftn.dr_help.comon.schedule.CalculateFirstFreeScheduleTest;
import com.ftn.dr_help.comon.schedule.NiceScheduleBeginningTest;
import com.ftn.dr_help.comon.schedule.RoundUntilMondayTest;
import com.ftn.dr_help.comon.schedule.WorkDayTest;
import com.ftn.dr_help.controller.AppointmentControllerPredefinedTest;
import com.ftn.dr_help.controller.AppointmentControllerRequestTest;
import com.ftn.dr_help.controller.AppointmentControllerTest;
import com.ftn.dr_help.controller.ClinicControllerListingTest;
import com.ftn.dr_help.controller.ProcedureTypeControllerTest;
import com.ftn.dr_help.controller.RoomControllerTest;
import com.ftn.dr_help.integration.AppointmentBlessingIntegrationTest;
import com.ftn.dr_help.integration.AppointmentGetPredefinedIntegrationTest;
import com.ftn.dr_help.integration.AppointmentReservePredefinedIntegrationTest;
import com.ftn.dr_help.integration.ClinicListingIntegrationTest;
import com.ftn.dr_help.integration.DoctorControllerIntegrationTest;
import com.ftn.dr_help.integration.DoctorControllerListingIntegrationTest;
import com.ftn.dr_help.integration.RoomIntegrationTest;
import com.ftn.dr_help.repository.AppointmentRepositoryTest;
import com.ftn.dr_help.repository.ClinicRepositoryTest;
import com.ftn.dr_help.repository.ClinicReviewRepositoryTest;
import com.ftn.dr_help.repository.DoctorRepositoryTest;
import com.ftn.dr_help.repository.DoctorReviewRepositoryTest;
import com.ftn.dr_help.repository.LeaveRequestRepositoryTest;
import com.ftn.dr_help.repository.ProcedureTypeRepositoryTest;
import com.ftn.dr_help.repository.RoomRepositoryTest;
import com.ftn.dr_help.service.AppointmentServiceTest;
import com.ftn.dr_help.service.ClinicServiceTest;
import com.ftn.dr_help.service.DoctorServiceTest;
import com.ftn.dr_help.service.NurseServiceTest;
import com.ftn.dr_help.service.OperationServiceTest;
import com.ftn.dr_help.service.ProcedureTypeServiceTest;
import com.ftn.dr_help.service.RoomServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ CheckRoomsTest.class,
				CalculateFirstFreeScheduleTest.class,
				CalculateFirstFreeOperationScheduleTest.class,
				NiceScheduleBeginningTest.class,
				RoundUntilMondayTest.class,
				WorkDayTest.class,
				AppointmentControllerTest.class,
				AppointmentControllerPredefinedTest.class,
				AppointmentControllerRequestTest.class,
				ClinicControllerListingTest.class,
				DoctorControllerListingIntegrationTest.class,
				ProcedureTypeControllerTest.class,
				RoomControllerTest.class,
				AppointmentBlessingIntegrationTest.class,
				AppointmentGetPredefinedIntegrationTest.class,
				AppointmentReservePredefinedIntegrationTest.class,
				ClinicListingIntegrationTest.class,
				DoctorControllerIntegrationTest.class,
				DoctorControllerListingIntegrationTest.class,
				RoomIntegrationTest.class,
				AppointmentRepositoryTest.class,
				ClinicRepositoryTest.class,
				ClinicReviewRepositoryTest.class,
				DoctorRepositoryTest.class,
				DoctorReviewRepositoryTest.class,
				LeaveRequestRepositoryTest.class,
				ProcedureTypeRepositoryTest.class,
				RoomRepositoryTest.class,
				AppointmentServiceTest.class,
				ClinicServiceTest.class,
				DoctorServiceTest.class,
				NurseServiceTest.class,
				OperationServiceTest.class,
				ProcedureTypeServiceTest.class,
				RoomServiceTest.class
				
})
public class AllTests {

}
