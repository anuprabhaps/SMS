Student Management System (SMS)
 Description:
 The Student Management System (SMS) allows the management of student records (Create,
 Read, Update, Delete- CRUD) along with a semester score board. It will store and retrieve
 student information such as ID, name, age, gender, email, and address using a relational
 database. The system will be developed using Java, Spring Boot, and Hibernate for ORM.
 Core Features:
 1. StudentEntity:
 ○ Attributes:
 ■ ID(unique,auto-generated)
 ■ Name(String)
 ■ Age(Integer)
 ■ Gender(String)
 ■ Email(String)
 ■ Address(String)
 ○ StudentClass:
 ■ AsimplePOJO(PlainOldJavaObject) with the above attributes,
 constructors, getters, and setters.
 2. CRUDOperations:
 ○ Create:Addanewstudent.
 ○ Read:RetrieveastudentbyID.
 ○ Update:Modifystudentdetails.
 ○ Delete:RemoveastudentrecordbyID.
 ○ ListAllStudents: Retrieve and display all students.
 3. Database:
 ○ UseJDBCfordatabaseconnection(MySQL/PostgreSQL).
 ○ UseHibernateORMforentitymappinganddatabaseoperations (using
 @Entity, @Table, etc.).
 4. SpringBoot:
 ○ APIEndpoints:
 ■ POST /students:Addanewstudent.
 ■ GET /students/{id}:GetstudentbyID.
 ■ PUT /students/{id}:Updatestudentinformation.
■ DELETE /students/{id}:DeleteastudentbyID.
 ■ GET /students:Listallstudents.
 ○ ServiceLayer:
 ■ Implementbusinesslogic in a service class that interacts with the
 database using Spring Data JPA repositories.
 ○ ControllerLayer:
 ■ ImplementRESTfulAPIsusingSpring@RestController.
 5. ExceptionHandling:
 ○ Handlecaseswhereastudentisnotfoundusingcustomexceptions (e.g.,
 StudentNotFoundException).
 ○ EnsureproperHTTPstatuscodesarereturned(e.g., 404 for not found, 200
 for success).
 6. Testing:
 ○ UnitTests:
 ■ WritetestsforCRUDoperations using JUnit.
 ■ UseMockitoformockingdatabaseinteractions during service
 testing.
 Additional Feature- Login and View Semester Results:
 1. StudentLogin:
 ○ Implementaloginsystemwherestudentscanloginusing their email and
 password.
 ○ Secureauthentication using Spring Security.
 ○ Passwordhashingforsecurity.
 2. ViewSemesterResults:
 ○ Afterlogin, students can view their semester results.
 ○ Displayresults with course names, grades for current semester
 ○ Createanentitybasedonthesefields.
 ○ AddanAPIendpoint:
 ■ GET /students/{id}/results:Retrievesemesterresults for the
 logged-in student.
 ○ Allowstudentstoseetheir academic history and scores for each semester
 (Optional).
Acceptance Criteria:
 1. Functionality:
 ○ Thesystemmustallowusersto:
 ■ Addanewstudenttothedatabase(Validate empty/invalid format).
 ■ Retrievestudent details by ID.
 ■ Updatestudentdetails.
 ■ Deleteastudentrecord.
 ■ Listallstudents.
 ■ Loginandviewsemesterresults.
 ○ AllCRUDoperationsmustbefunctional via REST API.
 2. Database:
 ○ Thestudentrecordsmustbestoredinarelational database
 (MySQL/PostgreSQL).
 ○ HibernateORMmustbeusedtomapStudententitiestodatabasetables.
 3. APIEndpoints:
 ○ TheRESTAPIendpointsshouldworkasexpected:
 ■ POST /students:Successfullyaddsastudent.
 ■ GET /students/{id}:Correctlyretrieves a student by ID.
 ■ PUT /students/{id}:Updatesstudentdata.
 ■ DELETE /students/{id}:Deletesastudent.
 ■ GET /students:Listsallstudents.
 ■ GET /students/{id}/results:Correctlyretrieves semester
 results.
 4. ExceptionHandling:
 ○ Whenastudentisnotfound(e.g., trying to update or delete a non-existing
 student), an appropriate exception should be thrown.
 ○ Customexceptionslike StudentNotFoundException should be handled
 with meaningful error messages.
 5. Testing:
 ○ Unittestsshould cover basic functionality (e.g., adding, retrieving, updating,
 and deleting students).
 ○ UseMockitotomockdependenciesandensurepropertesting without
 hitting the actual database.
