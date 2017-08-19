int validate(node root) {
2     if(root==NULL) return 1;
3     else if(root->lchild!=NULL && (root->lchild)->data >=root->data) return 0;
4     else if(root->rchild!=NULL && (root->rchild)->data <=root->data) return 0;
5     validate(root->lchild);
6     validate(root->rchild);
7     return 1;
8 }