export type Page = "HOME_PAGE";

interface NavigationAction {
  type: Page;
  payload?: {
  };
}

export const goToHome = (): NavigationAction => ({
  type: "HOME_PAGE"
});