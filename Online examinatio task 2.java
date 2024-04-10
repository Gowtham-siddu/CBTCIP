	package CBTCIP;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;
	
	public class Task2 {
			 private static Map<String, String> users = new HashMap<>();
			    private static Map<String, Map<Integer, String>> questions = new HashMap<>();
			    private static Map<String, Map<Integer, String>> answers = new HashMap<>();
			    private static Map<String, Long> timers = new HashMap<>();

			    public static void main(String[] args) {
			        // Initialize users, questions, and answers
			        initializeData();

			        Scanner scanner = new Scanner(System.in);
			        String currentUser = null;

			        while (true) {
			            System.out.println("1. Login");
			            System.out.println("2. Update Profile and Password");
			            System.out.println("3. Take Exam");
			            System.out.println("4. Logout");
			            System.out.print("Enter your choice: ");
			            int choice = scanner.nextInt();
			            scanner.nextLine(); // Consume newline character

			            switch (choice) {
			                case 1:
			                    currentUser = login(scanner);
			                    break;
			                case 2:
			                    updateProfileAndPassword(scanner, currentUser);
			                    break;
			                case 3:
			                    takeExam(scanner, currentUser);
			                    break;
			                case 4:
			                    currentUser = null;
			                    System.out.println("----------------------------------------------------Logged out successfully----------------------------------------------------");
			                    break;
			                default:
			                    System.out.println("Invalid choice. Please try again.");
			            }
			        }
			    }

			    private static void initializeData() {
			        // Add sample user data
			        users.put("user1", "password1");
			        users.put("user2", "password2");

			        // Add sample question and answer data
			        Map<Integer, String> questionMap1 = new HashMap<>();
			        questionMap1.put(1, "What is the capital of France? a) London  b) Paris  c) Berlin  d) Rome");
			        questionMap1.put(2, "What is the largest planet in our solar system?a) Venus  b) Mercury  c) Jupiter  d) Earth");
			        questions.put("user1", questionMap1);

			        Map<Integer, String> answerMap1 = new HashMap<>();
			        answerMap1.put(1, "Paris");
			        answerMap1.put(2, "Jupiter");
			        answers.put("user1", answerMap1);
			    }

			    private static String login(Scanner scanner) {
			        System.out.print("Enter username: ");
			        String username = scanner.nextLine();
			        System.out.print("Enter password: ");
			        String password = scanner.nextLine();

			        if (users.containsKey(username) && users.get(username).equals(password)) {
			            System.out.println("Login successful.");
			            
			            return username;
			        } else {
			            System.out.println("Invalid username or password.");
			            return null;
			        }
			    }

			    private static void updateProfileAndPassword(Scanner scanner, String currentUser) {
			        if (currentUser == null) {
			            System.out.println("Please login first.");
			            return;
			        }

			        System.out.print("Enter new password: ");
			        String newPassword = scanner.nextLine();
			        users.put(currentUser, newPassword);
			        System.out.println("----------------------------------------------------Profile and password updated successfully----------------------------------------------------");
			    }

			    private static void takeExam(Scanner scanner, String currentUser) {
			        if (currentUser == null) {
			            System.out.println("Please login first.");
			            return;
			        }

			        Map<Integer, String> questions = Task2.questions.get(currentUser);
			        Map<Integer, String> answers = Task2.answers.get(currentUser);
			        long startTime = System.currentTimeMillis();
			        timers.put(currentUser, startTime);

			        for (Map.Entry<Integer, String> entry : questions.entrySet()) {
			            int questionNumber = entry.getKey();
			            String question = entry.getValue();
			            System.out.println("Question " + questionNumber + ": " + question);
			            
			            System.out.print("Enter your answer: ");
			            String userAnswer = scanner.nextLine();

			            if (userAnswer.equalsIgnoreCase(answers.get(questionNumber))) {
			                System.out.println("Correct answer!");
			            } else {
			                System.out.println("Incorrect answer.");
			            }
			        }

			        long endTime = System.currentTimeMillis();
			        long duration = endTime - timers.get(currentUser);
			        System.out.println("Exam completed in " + (duration / 1000) + " seconds.");
			    }
	}
