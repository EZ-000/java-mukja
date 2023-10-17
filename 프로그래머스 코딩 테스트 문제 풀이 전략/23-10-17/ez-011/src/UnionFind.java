public class UnionFind {
    private static class Node {
        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if (isConnected(o)) return;

            Node root1 = root();
            Node root2 = o.root();

            if (root2.depth < root1.depth)  {
                root2.parent = root1;
            } else if (root1.depth < root2.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }

        private Node root() {
            if (parent == null) return this;
            return parent.root();
        }
    }

    private static class FastNode {
        private FastNode parent = null;

        public boolean isConnected(FastNode o) {
            return root() == o.root();
        }

        public void merge(FastNode o) {
            if (isConnected(o)) return;
            o.parent = this;
        }

        private FastNode root() {
            if (parent == null) return this;
            return parent = parent.root();
        }
    }
}
