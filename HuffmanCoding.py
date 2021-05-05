from typing import Any
class node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq
        self.symbol = symbol
        self.left = left
        self.right = right
        self.huff = ''

class HuffmanCoding:
    dic ={}
    def getDicFromNodes(node, val=''):
        newVal = val + str(node.huff)
        if(node.left):
            HuffmanCoding.getDicFromNodes(node.left, newVal)
        if(node.right):
            HuffmanCoding.getDicFromNodes(node.right, newVal)
        if(not node.left and not node.right):
            HuffmanCoding.dic[node.symbol] = newVal
        return HuffmanCoding.dic

    def build(self, text : str) -> Any:
        # finding the frequencoies of each character in the given string
        d = {}
        for char in text:
            if char in d:
                d[char]+=1
            else:
                d[char] = 1
        chars = list(d.keys())
        freq = list(d.values())
        # building the MAx tree of nodes
        nodes = []
        for x in range(len(chars)):
            nodes.append(node(freq[x], chars[x]))
        while len(nodes) > 1:
            #while loop to form the tree
            nodes = sorted(nodes, key=lambda x: x.freq)
            #taking the minimum 2 nodes
            left = nodes[0]
            right = nodes[1]
            #huff stores the binary digit and symbol stores the character
            left.huff = 0
            right.huff = 1
            newNode = node(left.freq+right.freq, left.symbol+right.symbol, left, right)
            nodes.remove(left)
            nodes.remove(right)
            nodes.append(newNode)
        xyz = HuffmanCoding.getDicFromNodes(nodes[0], val = '')
        return xyz

    def encode(self, Dic : Any, text : str) -> str:
        out = ''
        for ch in text:
            out += Dic[ch]
        return out

    def decode(self, Dic : Any, text : str) -> str:
        char = list(Dic.keys())
        encd = list(Dic.values())
        dec = ''
        i=0
        while len(text):
            if text[0:i] in encd:
                dec += char[encd.index(text[0:i])]
                text = text[i:]
                i=0
            i+=1
        return dec
