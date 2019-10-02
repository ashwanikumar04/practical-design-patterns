package in.ashwanik.pdp.template;

import lombok.Getter;

@Getter
class App {
    private Arena arena;

    App() {
        arena = new JungleArena(new TreeMesh());
    }
}
