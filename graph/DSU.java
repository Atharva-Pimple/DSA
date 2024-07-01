class DSU {

        int[] representative;
        int[] componentSize;
        int components;

        DSU(int n) {
            components = n;
            representative = new int[n+1];
            componentSize = new int[n+1];

            for(int i=0;i<=n;i++) {
                representative[i] = i;
                componentSize[i] = i;
            }
        }

        int findRepresentative(int x) {
            if(representative[x] == x) {
                return x;
            }

            return representative[x] = findRepresentative(representative[x]);
        }

        int preformUnion(int x, int y) {
            x = findRepresentative(x); y = findRepresentative(y);

            if(x==y) {
                return 0;
            }

            if(componentSize[x]>componentSize[y]) {
                componentSize[x]+=componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y]+=componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        boolean isConnected() {
            return components==1;
        }
    }