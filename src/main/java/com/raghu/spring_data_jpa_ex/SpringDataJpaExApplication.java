package com.raghu.spring_data_jpa_ex;

// import com.raghu.spring_data_jpa_ex.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.ApplicationContext;

import com.raghu.spring_data_jpa_ex.model.Student;
import com.raghu.spring_data_jpa_ex.repository.StudentRepo;

// import java.util.List;
// import java.util.Optional;

// @SpringBootApplication
// public class SpringDataJpaExApplication {

// 	public static void main(String[] args) {
// 		ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);

// 		StudentRepo repo = context.getBean(StudentRepo.class);
// //
// //
// //		Student s1 = context.getBean(Student.class);
// //		Student s2 = context.getBean(Student.class);
// 		Student s3 = context.getBean(Student.class);
// //
// //		s1.setRollNo(102);
// //		s1.setName("Raghu");
// //		s1.setMarks(95);
// //
// //		s2.setRollNo(103);
// //		s2.setName("Vamshi");
// //		s2.setMarks(90);
// //
// //		s3.setRollNo(101);
// //		s3.setName("KRV");
// //		s3.setMarks(92);
// //
// //		repo.save(s1);
// //		repo.save(s2);
// //		repo.save(s3);

// //		List<Student> st = repo.findAll();
// //		System.out.println("Values from DB below ");
// //		System.out.println(st);
// //
// //		Optional<Student> s = repo.findById(104);
// //
// //		System.out.println(s.orElse(new Student()));

// //
// //		System.out.println(repo.findByName("Raghu"));
// //		System.out.println(repo.findByMarks(90));
// //		System.out.println("findByMarksGreaterThan " + repo.findByMarksGreaterThan(90));
// //		System.out.println("findByMarksLessThan " + repo.findByMarksLessThan(95));
// //		System.out.println("findByMarksEquals " + repo.findByMarksEquals(92));

// 		//To update the data, we use save() but to pass data, we use the same student object to update.
// 		//Example i want to update name of the s3 object data, which was already is the database.

// 		s3.setRollNo(101);
// 		s3.setName("Kodali");	//KRV -> Kodali
// 		s3.setMarks(92);

// 		//repo.save(s3);
// 		repo.delete(s3);


// 	}

// }

@SpringBootApplication(
    exclude = {
        // This line prevents auto-configuration of R2DBC (Reactive DB),
        // which is causing issues due to missing classes like ValidationDepth.
        org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration.class
    }
)
public class SpringDataJpaExApplication {

    public static void main(String[] args) {
        // This starts the Spring Boot application
        SpringApplication.run(SpringDataJpaExApplication.class, args);
    }

    // CommandLineRunner runs after the Spring context is initialized
    @Bean
    public CommandLineRunner run(StudentRepo repo) {
        return args -> {
            // Creating a new Student object with roll number 101
            Student s3 = new Student();
            s3.setRollNo(101);
            s3.setName("Kodali");
            s3.setMarks(92);

            // Instead of blindly deleting, we check if student exists
            if (repo.existsById(101)) {
                repo.deleteById(101); // Safer deletion using ID
                System.out.println("Student with roll number 101 deleted successfully.");
            } else {
                System.out.println("Student with roll number 101 not found.");
            }

            // To save the student instead of deleting, comment the above block
            // and uncomment below line:
            // repo.save(s3);
        };
    }
}
