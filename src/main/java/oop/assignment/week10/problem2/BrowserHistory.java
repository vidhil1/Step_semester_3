
public class BrowserHistory {

    static class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }

    private Node current;

    public BrowserHistory(String homePage) {
        current = new Node(homePage);
    }

    public String visit(String url) {
        Node newNode = new Node(url);

        current.next = newNode;
        newNode.prev = current;

        current = newNode;

        return current.url;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }

        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }

        return current.url;
    }

    public String getCurrentPage() {
        return current.url;
    }

    public static void main(String[] args) {

        BrowserHistory browser =
                new BrowserHistory("srm.edu");

        System.out.println(browser.visit("a.com"));
        System.out.println(browser.visit("b.com"));
        System.out.println(browser.visit("c.com"));

        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));

        System.out.println(browser.visit("d.com"));

        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.back(7));
    }
}
