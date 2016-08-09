This is an experimental Yocto layer to provide updated wayland &
gtk+3 recipees for RZ/G1E.
The version of gtk+3 incldued in the current BSP of RZ/G1E is 3.10
which doesn't support xdg-shell protocol on wayland. Therefore
gtk+3 applications on it can't move/resize windows. This layer
aims to resolve this issue.

