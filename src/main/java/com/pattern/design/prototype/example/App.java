package com.pattern.design.prototype.example;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("jini");
        repository.setName("us");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("prototype pattern study");

        GithubIssue clone = (GithubIssue) githubIssue.clone();

        System.out.println(githubIssue != clone);
        System.out.println(githubIssue.equals(clone));
        System.out.println(githubIssue.getClass() == clone.getClass());
        System.out.println(githubIssue.getRepository() != clone.getRepository());
    }
}
