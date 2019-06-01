import { getPage } from "../store/selectors/navigation";
import { connect } from "react-redux";
import { State } from "../store";

const mapStateToProps = (state: State) => ({
  page: getPage(state),
});

const mapDispatchToProps = {
};

export default connect(mapStateToProps, mapDispatchToProps);
