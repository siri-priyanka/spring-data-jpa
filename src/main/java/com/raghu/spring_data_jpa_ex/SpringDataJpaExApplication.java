// package com.raghu.spring_data_jpa_ex;

// import com.raghu.spring_data_jpa_ex.model.Student;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;

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

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StudentRepo repo) {
		return args -> {
			Student s3 = new Student();
			s3.setRollNo(101);
			s3.setName("Kodali");
			s3.setMarks(92);

			repo.delete(s3);  // Or better: repo.deleteById(101);
			System.out.println("Student deleted successfully.");
		};
	}
}
