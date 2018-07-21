import sys
def optimalStops(U, subsets):
    elements = set(e for s in subsets for e in s)
    if elements != U:
        return None
    covered = set()
    cover = []
    while covered != elements:
        subset = max(subsets, key=lambda s: len(s - covered))
        cover.append(subset)
        covered |= subset
 
    return cover
def main():
    with sys.stdin as f:
        N, R = [int(x) for x in next(f).split()]
        stops = [[int(x) for x in line.split()] for line in f][0]
        st = min(stops)
        et = max(stops)
        U = set(range(st, et + 1))
        subsets = [(set(range(max(y - R,st), min(y + R,et) + 1))) for y in stops]
        cover = optimalStops(U, subsets)
        sys.stdout.write("%s\n" % len(cover))
 
if __name__ == '__main__':
    main()