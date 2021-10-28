import sys
import threading

sys.setrecursionlimit(10 ** 7)  # max depth of recursion
threading.stack_size(2 ** 27)  # new thread will get stack of such size

tree = {}


def is_binary_search_tree(node_index: int, min_key: int, max_key: int) -> bool:
    if node_index not in tree:
        return True
    if tree[node_index][0] < min_key or tree[node_index][0] > max_key:
        return False

    return is_binary_search_tree(tree[node_index][1], min_key, tree[node_index][0] - 1) \
           and is_binary_search_tree(tree[node_index][2], tree[node_index][0], max_key)


def main():
    global tree

    nodes = int(sys.stdin.readline().strip())
    int_max, int_min = 2147483647, -2147483648

    for i in range(nodes):
        tree[i] = (list(map(int, sys.stdin.readline().strip().split())))
    if is_binary_search_tree(0, int_min, int_max):
        print("CORRECT")
    else:
        print("INCORRECT")


if __name__ == '__main__':
    threading.Thread(target=main).start()
