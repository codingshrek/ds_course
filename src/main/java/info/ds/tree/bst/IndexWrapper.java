package info.ds.tree.bst;

class IndexWrapper {

    private Integer index;

    public IndexWrapper(Integer index) {
        this.index = index;
    }

    public void increment() {
        this.index = this.index + 1;

    }

    public Integer getIndex() {
        return this.index;
    }
}
