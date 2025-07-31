class BrowserHistory {
    // Using Striver Sheet Solution Helpful in doubly linked
    class Node {
        String data;
        Node next;
        Node prev;
        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node currentPage;

    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        currentPage.next = newNode;
        newNode.prev = currentPage;
        currentPage = newNode;  
        currentPage.next = null;
    }

    public String back(int steps) {
        while (steps > 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
            steps--;
        }
        return currentPage.data;
    }

    public String forward(int steps) {
        while (steps > 0 && currentPage.next != null) {
            currentPage = currentPage.next;
            steps--;
        }
        return currentPage.data;
    }
}
