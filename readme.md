
# Incubator

> "Conceptual knowledge is not enough ... you must have the conviction that comes from personal experience." - The 9th Gyalwa Karmapa.

The project is an incubator - it contains different modules and serves different purposes:

- via-negativa 1 - showcase: there are 1001 way to shoot yourself in the foot, but only a few to do according expectations;
- via-negativa 2 - drop smt: the MVP examples of minimal permutations of components required to achieve some goal so it is easy to drop some component and check what will happen; unlike big projects, it's easy to track relations what affects what;
- in form of runnable code - the actual phenomenon that can be observed;
- pieces of apps' skeletons;
- if you gaze long into an abyss...: by checking the code again and again I internalized the structure so that I can easily recall it mentally;
- early stage projects: once a project is mature enough, I extract it into a separate project;
- atomic koans: predict what will be printed or fix something.

# UUID structure

The project heavily relies on UUIDs as package names. This is value / CAPEX tradeoff - might look ugly, but on the other hand eliminates the burden of coming up and then supporting package names.

Anyway, modules' names narrow the scope enough.