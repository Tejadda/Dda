import java.util.*;
import java.text.*;

class College implements Comparable<College> {
    private String name;
    private String website;
    private String mobile;
    private String founder;
    private Integer numberOfDept;
    private String location;
    private Date startingDate;

    public College() {}

    public College(String name, String website, String mobile, String founder, Integer numberOfDept, String location, Date startingDate) {
        this.name = name;
        this.website = website;
        this.mobile = mobile;
        this.founder = founder;
        this.numberOfDept = numberOfDept;
        this.location = location;
        this.startingDate = startingDate;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getNumberOfDept() {
        return numberOfDept;
    }

    public void setNumberOfDept(Integer numberOfDept) {
        this.numberOfDept = numberOfDept;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    // Method to create College object from string details
    public static College createCollege(String detail) throws ParseException {
        String[] details = detail.split(",");
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return new College(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]), details[5], format.parse(details[6]));
    }

    @Override
    public int compareTo(College college) {
        return this.name.compareTo(college.getName());
    }
}

class StartingDateComparator implements Comparator<College> {
    @Override
    public int compare(College c1, College c2) {
        return c1.getStartingDate().compareTo(c2.getStartingDate());
    }
}

class DepartmentComparator implements Comparator<College> {
    @Override
    public int compare(College c1, College c2) {
        return c1.getNumberOfDept().compareTo(c2.getNumberOfDept());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of colleges:");
        int numColleges = Integer.parseInt(scanner.nextLine());
        List<College> colleges = new ArrayList<>();

        // Input colleges
        for (int i = 0; i < numColleges; i++) {
            try {
                System.out.println("Enter college details separated by comma (name, website, mobile, founder, numberOfDept, location, startingDate):");
                College college = College.createCollege(scanner.nextLine());
                colleges.add(college);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in dd-MM-yyyy format.");
                i--; // Retry input
            }
        }

        // Sort colleges based on user choice
        System.out.println("Enter a type to sort:");
        System.out.println("1. Sort by name");
        System.out.println("2. Sort by number of departments");
        System.out.println("3. Sort by starting date");
        int sortType = Integer.parseInt(scanner.nextLine());

        switch (sortType) {
            case 1:
                Collections.sort(colleges);
                break;
            case 2:
                Collections.sort(colleges, new DepartmentComparator());
                break;
            case 3:
                Collections.sort(colleges, new StartingDateComparator());
                break;
            default:
                System.out.println("Invalid sort type.");
                return;
        }

        // Print sorted colleges
        System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n", "Name", "Website", "Mobile", "Founder", "No of departments", "Location", "Starting date");
        for (College college : colleges) {
            System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",
                    college.getName(), college.getWebsite(), college.getMobile(), college.getFounder(),
                    college.getNumberOfDept(), college.getLocation(), college.getStartingDate());
        }
    }
}
